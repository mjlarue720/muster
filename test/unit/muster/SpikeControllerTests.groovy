package muster



import org.junit.*
import grails.test.mixin.*

@TestFor(SpikeController)
@Mock(Spike)
class SpikeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/spike/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.spikeInstanceList.size() == 0
        assert model.spikeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.spikeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.spikeInstance != null
        assert view == '/spike/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/spike/show/1'
        assert controller.flash.message != null
        assert Spike.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/spike/list'

        populateValidParams(params)
        def spike = new Spike(params)

        assert spike.save() != null

        params.id = spike.id

        def model = controller.show()

        assert model.spikeInstance == spike
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/spike/list'

        populateValidParams(params)
        def spike = new Spike(params)

        assert spike.save() != null

        params.id = spike.id

        def model = controller.edit()

        assert model.spikeInstance == spike
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/spike/list'

        response.reset()

        populateValidParams(params)
        def spike = new Spike(params)

        assert spike.save() != null

        // test invalid parameters in update
        params.id = spike.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/spike/edit"
        assert model.spikeInstance != null

        spike.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/spike/show/$spike.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        spike.clearErrors()

        populateValidParams(params)
        params.id = spike.id
        params.version = -1
        controller.update()

        assert view == "/spike/edit"
        assert model.spikeInstance != null
        assert model.spikeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/spike/list'

        response.reset()

        populateValidParams(params)
        def spike = new Spike(params)

        assert spike.save() != null
        assert Spike.count() == 1

        params.id = spike.id

        controller.delete()

        assert Spike.count() == 0
        assert Spike.get(spike.id) == null
        assert response.redirectedUrl == '/spike/list'
    }
}
