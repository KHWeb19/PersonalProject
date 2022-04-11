<template>
  <div>
    <menu-bar/>
      <v-container style="width: 700px; margin-top: 20px; padding-left: 0px">
      <v-flex>
          <v-card style="height: 320px">
      <router-link style="text-decoration: none;" :to="{name: 'LoginPage'}">
        &nbsp;Login&nbsp;
      </router-link>
      <router-link style="text-decoration: none;" :to="{name: 'RegisterPage'}">
        &nbsp;Register&nbsp;
      </router-link>

      <member-list :members="members"/>
          </v-card>
          </v-flex>
    </v-container>

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