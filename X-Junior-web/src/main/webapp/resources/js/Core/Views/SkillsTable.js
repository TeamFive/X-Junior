define(["Collections/Skills", "Views/Base", "App", "jquery"], function (Skills, Base, App, $){
    return Base.extend({
        events: {
            "click .fa-times": "delete"

        },

        delete:function(event){

            this.collection= new Skills();
            this.collection.remove($(event.target).data("id"));
            $(event.target).parent().detach();



        },

        constructor: function(options){
            options.collection = new Skills();
            this.listenTo(options.collection, "add", this.addline);


            Base.prototype.constructor.apply(this, [options]);
        },


        addline:function(skill){

            this.$el.append("<li>" + skill.get("name") + "<i data-id='"+ skill.get('id') +"' class='fa fa-times'></i></li>");
        }



    }, {
        defaults: $.extend(true, {}, Base.defaults, {
            tpl: {
                src: "form.skillstable.html?v=1"
            },
            formTitle :"skills table"


        })
    });


});