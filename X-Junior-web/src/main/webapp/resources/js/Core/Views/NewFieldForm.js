define(["Views/Base", "jquery", "Views/AddTextFieldForm", "Views/AddRadioFieldForm", "Views/AddCheckboxFieldForm"], function (View, $, AddTextFieldForm, AddRadioFieldForm, AddCheckFieldForm) {
    return View.extend({
        events: {
            "click .choise-text": "addTextForm",
            "click .choise-radio": "addRadioForm",
            "click .choise-check": "addCheckForm"

        },


        addTextForm: function (event) {

            $("div").remove(".check-form");
            $("div").remove(".radio-form");
            $("div").remove(".text-form");
            var form = new AddTextFieldForm({
                "container": this.$el,
                "containerResolveMethod": "append"
            });

            form.show();
        },

        addRadioForm: function (event) {

            $("div").remove(".check-form");
            $("div").remove(".radio-form");
            $("div").remove(".text-form");
            var form = new AddRadioFieldForm({
                "container": this.$el,
                "containerResolveMethod": "append"
            });

            form.show();
        },

        addCheckForm: function (event) {
            $("div").remove(".check-form");
            $("div").remove(".radio-form");
            $("div").remove(".text-form");

            var form = new AddCheckFieldForm({
                "container": this.$el,
                "containerResolveMethod": "append"
            });

            form.show();
        },


        alertIt: function (field) {
            alert(JSON.stringify(field.name));
        }






    }, {


        defaults: $.extend(true, {}, View.defaults, {
            tpl: {
                src: "form.newfield.html?v=1"
            },
            "submitButton": ".submit-button",

        })
    });
});