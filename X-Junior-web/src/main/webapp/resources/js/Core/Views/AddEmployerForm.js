/**
 * Created by Administrator on 28.07.2014.
 */
define(["Views/Form", "App", "jquery", "Collections/Employers", "Models/Employer"], function(Form, App, $, Employers, Employer){
    return Form.extend({
        events: $.extend(true, {}, Form.prototype.events, {
            "view:parent:hide": "reset"
        }),
        
        constructor: function(options){
            options.collection = new Employers();
            Form.prototype.constructor.apply(this,[options]);
        },

        __sendData: function(data){
            this.model = new Employer();
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
                src: "form.addemployer.html?v=2"
            },
            submitButton: ".button-create",
            submitButtonText: "Create",
            nameText: "Curator's name",
            emailText: "Curator's email",
            emailPlaceholder: "matr369@exadel.com",
            namePlaceholder: "Evgene Ivashkevich"
        })
    });
});