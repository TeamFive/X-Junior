define(["Models/Base", "underscore", "Collections/Skills"], function(Model, _, Skills){
    var allskills=[];

    return Model.extend({
        defaults:{
           name:""

        }


/*



        constructor: function(){

            if (this.constructor._instance) {
                return this.constructor._instance;
            } else {
                Model.prototype.constructor.apply(this, arguments);
                this.constructor._instance = this;
            }
        },

        add: function(name){
            if (_.findIndex(this.get("list"), function(sn){return sn==name})===-1) {

                this.get("list").push(name);
                this.trigger("add", name);


            }

        }*/
    });
});