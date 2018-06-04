require('./bootstrap');
require('../../node_modules/lightbox2/dist/js/lightbox-plus-jquery')

window.Vue = require('vue');

import RegisterComponent from './components/RegisterComponent.vue';
import HelpComponent from './components/HelpComponent.vue';
import VeeValidate from 'vee-validate';

Vue.use(VeeValidate);

const app = new Vue({
    el: '#app',
    components: {
        RegisterComponent,
        HelpComponent,
    },
    mounted() {

    },
});
