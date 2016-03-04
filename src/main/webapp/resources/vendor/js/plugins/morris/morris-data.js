$(function() {
    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: 'Repas',
            a: 100,
            b: 90
        }, {
            y: 'Repas boulot',
            a: 75,
            b: 65
        }, {
            y: 'Alison',
            a: 50,
            b: 40
        }, {
            y: 'Saskia',
            a: 75,
            b: 65
        }, {
            y: 'Poche',
            a: 50,
            b: 40
        }, {
            y: '2011',
            a: 75,
            b: 65
        }, {
            y: '2012',
            a: 100,
            b: 90
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Budget', 'Courant'],
        hideHover: 'auto',
        resize: true
    });

});
