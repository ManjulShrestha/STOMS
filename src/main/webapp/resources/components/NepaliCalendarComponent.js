PrimeFaces.widget.NepaliCalendarComponent = PrimeFaces.widget.BaseWidget.extend({
    init : function(cfg) {
        this._super(cfg);
        
        var id = this.jqId.replace(new RegExp('\\:','g'),'-');
        
        
        this.input = jQuery(id+"_hidden");
        this.name = cfg.widgetName;
        this.type = cfg.type;
        this.calender = jQuery(id+"_calender");
        this.calender.mask('0000-00-00',{placeholder:'yyyy-mm-dd'})
        this.calender.val(this.input.val());
        
        
        
        var that = this;
        $(document).ready(function(){
            that.calender.nepaliDatePicker({
                onChange: function(){
                    that.input.val(that.calender.val());
                    if(that.cfg.behaviors && that.cfg.behaviors.change){
                        that.cfg.behaviors.change.call(that.input);
                    }
                },
                onFocus: false,
                npdMonth: true,
                npdYear: true,
                ndpTriggerButton: true,
                ndpTriggerButtonText: ' ',
                ndpTriggerButtonClass: 'btn-nepali-calendar icon-calendar'
            });
        });
		
    }
});