<template>
  <div>
    <menu-bar/>
    <router-link style="text-decoration: none;" :to="{name: 'LoginPage'}">
      &nbsp;Login&nbsp;
    </router-link>
    <router-link style="text-decoration: none;" :to="{name: 'RegisterPage'}">
      &nbsp;Register&nbsp;
    </router-link>
    <div>
    로그인 넘버: {{id}}
    </div>
    <router-link :to="{
                        path: `accounts/edit/${no}`,
}">
                    회원정보
                    </router-link>
    <member-list :members="members"/>
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
        this.fetchMemberList()
    },
    methods: {
        ...mapActions(['fetchMemberList'])
    },
    data() {
      return {
      id: this.$store.state.memberId,
      no: 8
      }
      
    }
  
}
</script>

<style>


</style>