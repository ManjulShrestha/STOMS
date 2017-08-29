PrimeFaces.widget.Layout = PrimeFaces.widget.BaseWidget.extend({
    init: function(cfg){
        this._super(cfg);
        this.cfg = cfg;
        this.id = cfg.id;
        this.jqTarget = $(cfg.forTarget);
        
        var _self = this;
        if(this.jqTarget.is(':visible')){
            this.createLayout();
        } else {
            var hiddenParent = this.jqTarget.parents
            ('.ui-hidden-container:first');
            var hiddenParentWidget = hiddenParent.data('widget');
            if(hiddenParentWidget){
                hiddenParentWidget.addOnshowHandler(function(){
                    return _self.createLayout();
                });
            }
        }
    },
    createLayout:function(){
        this.layout = this.jqTarget.layout(this.cfg.options);
        this.bindEvents(this.jqTarget);
    },
    
    bindEvents: function(parent){
        
    },
    
    toogle: function(pane){
        this.jqTarget.find('.ui-layout-pane').
                each(function(){
                    var combinedPosition = $(this).data('combinedposition');
                    if(combinedPosition && combinedPosition === 'pane'){
                        $(this).trigger("layoutpanetoggle");
                        return false;
                    }
        });
    }
    
    
});