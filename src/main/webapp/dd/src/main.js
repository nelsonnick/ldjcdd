import Vue from 'vue'
import store from './store'
import ViewUI from 'view-design';
import 'view-design/dist/styles/iview.css';
import App from './App.vue'

Vue.config.productionTip = false

Vue.use(ViewUI);

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
