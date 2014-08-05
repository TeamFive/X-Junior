define(["Views/Form", "App", "Collections/Skills", "Models/Skill"], function(Form, App, Skills, Skill){
    return Form.extend({

        constructor: function(options){
            options.collection = new Skills();
            Form.prototype.constructor.apply(this, [options]);
        },



        __sendData:function(skill){
            debugger;
            return $.Deferred().resolve(skill);
        },

        onSuccessSubmit: function(skill){
            if (this.verify() === true)
            {
                _.each(this.fields || [], function(field){
                    debugger;
                    field.reset();
                });
            }

           if(this.collection.where({name:skill.name}).length==0)
           this.collection.add(skill);



        }


    }, {
        defaults: $.extend(true, {}, Form.defaults, {
            tpl: {
                src: "form.newskill.html?v=1"
            },
            formTitle :"new skill"


        })
    });
});