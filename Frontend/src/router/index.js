import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Welcome from '@/components/Welcome'
import CreateAccount from '@/components/CreateAccount'
import Dashboard from '@/components/Dashboard'
import ConfirmStudentStart from '@/components/ConfirmStudentStart'
import ConfirmStudentCompletion from '@/components/ConfirmStudentCompletion'
import DownloadCoopForm from '@/components/DownloadCoopForm'
import TaxCreditForm from '@/components/TaxCreditForm'
import DownloadTaxCreditForm from '@/components/DownloadTaxCreditForm'
import LoginPage from '@/components/LoginPage'
import ConfirmStudentCompletionSecondPage from '@/components/ConfirmStudentCompletionSecondPage'
import ConfirmStudentStartSecondPage from '@/components/ConfirmStudentStartSecondPage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/hello',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/',
      name: 'Welcome',
      component: Welcome


    },
    {
      path: '/createAccount',
      name: 'CreateAccount',
      component: CreateAccount
    }
    ,
    {
      path: '/Dashboard/:employerID',
      name: 'Dashboard',
      component: Dashboard
    }
    ,
    {
      path: '/ConfirmStudentStart/:employerID',
      name: 'ConfirmStudentStart',
      component: ConfirmStudentStart
    }
    ,
    {
      path: '/ConfirmStudentCompletion/:employerID',
      name: 'ConfirmStudentCompletion',
      component: ConfirmStudentCompletion
    }
    ,
    {
      path: '/DownloadCoopForm/:employerID',
      name: 'DownloadCoopForm',
      component: DownloadCoopForm
    }
    ,
    {
      path: '/TaxCreditForm/:employerID',
      name: 'TaxCreditForm',
      component: TaxCreditForm
    }
    ,
    {
      path: '/DownloadTaxCreditForm/:employerID',
      name: 'DownloadTaxCreditForm',
      component: DownloadTaxCreditForm
    }
    ,
    {
      path: '/LoginPage',
      name: 'LoginPage',
      component: LoginPage
    },
    {
      path: '/LoginPage/:employerID',
      name: 'LoginPageEmployerID',
      component: LoginPage
    }
  ]
})
