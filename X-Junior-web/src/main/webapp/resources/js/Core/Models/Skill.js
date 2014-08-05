define(["Models/Base", "underscore", "Collections/Skills"], function(Model, _, Skills){
    var allskills=[];

    return Model.extend({
        defaults:{
           technology_name: ""
        },
        urlRoot: "/technology"
    });
});