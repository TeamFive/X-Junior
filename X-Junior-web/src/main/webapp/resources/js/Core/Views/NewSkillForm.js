define(["Views/Form", "App", "Collections/Skills", "Models/Skill"], function(Form, App, Skills, Skill){
    return Form.extend({

        constructor: function(options){
            options.collection = new Skills();
            Form.prototype.constructor.apply(this, [options]);
        },

        onSuccessSubmit: function(skill){
            this.reset();
        }


    }, {
        defaults: $.extend(true, {}, Form.defaults, {
            tpl: {
                src: "form.newskill.html?v=1"
            },
            prepareCollection: false,
            formTitle :"new skill"


        })
    });
});