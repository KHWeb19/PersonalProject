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
          params: {memberId: memberId.toString()}}">
          로그인회원넘버: {{memberId}}
          
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
    data() {
      return {
      // loginNo: this.$store.state.member.memberNo,
      // loginNo: 8
      memberId: localStorage.getItem("loginId")
      // memberId: 'test'
      }
    },
    computed: {
        ...mapState(['members']),
        
    },
    mounted () {
        this.fetchMemberList()
    },
    methods: {
        ...mapActions(['fetchMemberList']),
    },
}
</script>

<style>


</style>