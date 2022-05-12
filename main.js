require('./bootstrap');
import router from "./routers/router"
import VueSweetalert2 from 'vue-sweetalert2';
import "../../../../../../node_modules/croppie/croppie.css"
import store from "./store/index.js"
import 'element-ui/lib/theme-chalk/index.css'
import VueBreadcrumbs from 'vue-breadcrumbs'
import Buefy from 'buefy';
// import vuetify from './plugins/vuetify';
import VCalendar from 'v-calendar';
import 'buefy/dist/buefy.css'
import 'bulma';
import "../../css/tailwind.css"
import "../../css/app.scss"
import 'font-awesome/css/font-awesome.min.css'
import Tooltip from 'vue-directive-tooltip';
import 'vue-directive-tooltip/src/css/index.scss';
import 'vue-form-wizard/dist/vue-form-wizard.min.css'
import VueTextareaAutosize from 'vue-textarea-autosize'

window.Vue = require('vue');
// if (PRODUCTION) {
//     Vue.config.devtools = false;
//     Vue.config.debug = false;
//     Vue.config.silent = true;
// }
Vue.use(Tooltip, {
    delay: 50,
    triggers: ['hover'],
    offset: 0
});

Vue.use(router);

const router = new router({
    router:router

});

Vue.use(VueBreadcrumbs, {
    template: `
        <div v-if="$breadcrumbs.length" class="ant-breadcrumb breadcrumb">
        <nav class="breadcrumb is-small" aria-label="breadcrumbs">
  <ul>
    <li tag="span" v-for="(crumb, key) in $breadcrumbs" :class="{'is-active':key==$breadcrumbs.length-1}" :to="linkProp(crumb)" :key="key">
    <router-link :to="linkProp(crumb)">
    <span v-if="crumb.meta.breadcrumbIcon" class="icon is-small">
          <i :class="crumb.meta.breadcrumbIcon" class="fa" aria-hidden="true"></i>
        </span>
    {{ crumb | crumbText }}
    </router-link></li>
  </ul>
</nav>
</div>`

});

Vue.use(VueSweetalert2);

Vue.use(VueTextareaAutosize);

Vue.use(Buefy, {
    defaultIconPack: 'fa',
});

Vue.use(VCalendar, {
    componentPrefix: 'vc'  // Use <vc-calendar /> instead of <v-calendar />
});
window.Vue = require('vue');
const app = new Vue({
    // vuetify,
    router: router,
    store,
    el: "#app-root",
});
