/**
 * Created by Administrator on 06.08.2014.
 */
define(["Views/Form", "App", "jquery", "Collections/Managers", "Models/Manager"], function(Form, App, $, Managers, Manager){
    return Form.extend({
        events: $.extend(true, {}, Form.prototype.events, {
            "view:parent:hide": "reset"
        }),

        constructor: function(options){
            options.collection = new Managers();
            Form.prototype.constructor.apply(this,[options]);
        },

        __sendData: function(data){
            this.model = new Manager();
            return Form.prototype.__sendData.apply(this,arguments);
        },

        onSuccessSubmit: function(data){
            this.collection.add(data);
            Form.prototype.onSuccessSubmit.apply(this, arguments);
        },

        onCompleteSubmit: function(){
            delete this.model;
            Form.prototype.onCompleteSubmit.apply(this, arguments);
        }

    }, {


        defaults: $.extend(true, {}, Form.defaults, {
            tpl: {
                src: "form.addmanager.html?v=2"
            },
            submitButton: ".button-create",
            submitButtonText: "Create",
            nameText: "Manager's name",
            emailText: "Manager's email",
            emailPlaceholder: "matr369@exadel.com",
            namePlaceholder: "Evgene Ivashkevich"
        })
    });
});