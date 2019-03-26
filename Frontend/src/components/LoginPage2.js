import axios from 'axios'
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = (config.dev.backendPort == "443"? 'https://' : "http://") + config.dev.backendHost + (config.dev.backendPort == "443"? (':' + config.dev.backendPort) : "");

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})


function EmployerLoginDto (employerID ) {
  this.employerID = employerID
}


export default {
  name: 'employerLogin',
  data () {
    return {
      employer: [],
      newEmployer: '',
      errorEmployer: '',
      response: [],
      employerID: null
    }
  },
  // localhost:8080/Employer/111
  methods: {
    loginEmployer: function (employerID) {
      AXIOS.get('/Employer/' + employerID)
      .then(response => {
        // JSON responses are automatically parsed.
        console.log("GOOD");
        //name: 'TreeMapResident', params: { resident: loggedin.email }
        this.$router.push({name : 'Dashboard', params: {employerID: employerID}});

      })
      .catch(e => {
        var errorMsg = e.message
        console.log(errorMsg);
      });
    },
    checkForm: function(e){
      var oops = false
      if(!this.employerID){oops=true;}

      // This prevents the default action of the event from being executed!
      e.preventDefault();

      if(oops){
        console.log("WRITE SOMETHING!");
        return;
      }
      else {
        this.loginEmployer(this.employerID);
      }
    }
  }
}

