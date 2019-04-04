import axios from 'axios'
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default {
  name: 'TaxCredit',
  data() {
    return {
      employerID: null
    }
  },
  created: function () {
    this.employerID = this.$route.params.employerID;
  }
}










