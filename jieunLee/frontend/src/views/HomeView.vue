<template>
  <div>
    <menu-bar/>
    <router-link style="text-decoration: none;" :to="{name: 'LoginPage'}">
      &nbsp;Login&nbsp;
    </router-link>
    <router-link style="text-decoration: none;" :to="{name: 'RegisterPage'}">
      &nbsp;Register&nbsp;
    </router-link>

    <member-list :members="members"/>

    <router-link :to="{
        name: 'AccountsEditPage',
        params: {memberNo: mem.toString()}}">
        로그인멤버 {{mem}}
    </router-link>

  </div>
</template>

<script>
import MemberList from '@/components/member/MemberList.vue'
import MenuBar from '@/components/MenuBar.vue'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'HomeView',
  components: {
    MenuBar,
    MemberList
    },
    computed: {
        ...mapState(['members'])
    },
    mounted () {
        this.fetchMemberList(),
        this.fetchMember()
    },
    methods: {
        ...mapActions(['fetchMemberList'])
    },
    data() {
      return {
      loginNo: 8,
      // loginNo: this.$store.state.userInfo.memberNo,
      mem: this.$store.state.member.memberNo,
      // mem: 8
      }
      
    },

  
}
</script>

<style>


</style>