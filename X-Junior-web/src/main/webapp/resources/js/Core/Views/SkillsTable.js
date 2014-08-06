define(["Collections/Skills", "Views/Base", "App", "jquery"], function (Skills, Base, App, $){
    return Base.extend({
        events: {
            "click .fa-times": "destroy"

        },

        destroy:function(event){
            this.collection.remove($(event.target).data("id"));
            $(event.target).parent().detach();
        },

        constructor: function(options){
            options.collection = new Skills();
            this.listenTo(options.collection, "add remove", this.rerender);
            Base.prototype.constructor.apply(this, arguments);
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