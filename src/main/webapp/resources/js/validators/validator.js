alert('done');

PrimeFaces.validator['test'] = {
    validate: function(element,value){
        alert('client side validator');
    }
}
