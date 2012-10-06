package muster

import org.springframework.dao.DataIntegrityViolationException

class SpikeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [spikeInstanceList: Spike.list(params), spikeInstanceTotal: Spike.count()]
    }

    def create() {
        [spikeInstance: new Spike(params)]
    }

    def save() {
        def spikeInstance = new Spike(params)
        if (!spikeInstance.save(flush: true)) {
            render(view: "create", model: [spikeInstance: spikeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'spike.label', default: 'Spike'), spikeInstance.id])
        redirect(action: "show", id: spikeInstance.id)
    }

    def show(Long id) {
        def spikeInstance = Spike.get(id)
        if (!spikeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'spike.label', default: 'Spike'), id])
            redirect(action: "list")
            return
        }

        [spikeInstance: spikeInstance]
    }

    def edit(Long id) {
        def spikeInstance = Spike.get(id)
        if (!spikeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'spike.label', default: 'Spike'), id])
            redirect(action: "list")
            return
        }

        [spikeInstance: spikeInstance]
    }

    def update(Long id, Long version) {
        def spikeInstance = Spike.get(id)
        if (!spikeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'spike.label', default: 'Spike'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (spikeInstance.version > version) {
                spikeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'spike.label', default: 'Spike')] as Object[],
                          "Another user has updated this Spike while you were editing")
                render(view: "edit", model: [spikeInstance: spikeInstance])
                return
            }
        }

        spikeInstance.properties = params

        if (!spikeInstance.save(flush: true)) {
            render(view: "edit", model: [spikeInstance: spikeInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'spike.label', default: 'Spike'), spikeInstance.id])
        redirect(action: "show", id: spikeInstance.id)
    }

    def delete(Long id) {
        def spikeInstance = Spike.get(id)
        if (!spikeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'spike.label', default: 'Spike'), id])
            redirect(action: "list")
            return
        }

        try {
            spikeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'spike.label', default: 'Spike'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'spike.label', default: 'Spike'), id])
            redirect(action: "show", id: id)
        }
    }
}
