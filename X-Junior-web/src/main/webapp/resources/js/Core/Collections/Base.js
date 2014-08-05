/**
 * Created by dmantsevich on 7/18/2014.
 */
define(["Backbone", "Models/Base", "jquery"], function(Backbone, Model, $){
    return Backbone.Collection.extend({
        model: Model,
        at: function(position){
            return Backbone.Collection.prototype.at.call(this, position || 0);
        }
    });
});