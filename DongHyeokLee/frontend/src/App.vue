<template>

  <v-app>
    
   
   <member-bar :members="memberLists"></member-bar>
   <nav-bar></nav-bar>
    

    <v-main>
      <router-view/>
    </v-main>
  </v-app>

</template>

<script>

import NavBar from '@/views/bar/NavBar.vue'
import MemberBar from '@/views/bar/MemberBar.vue'

import { mapActions, mapState } from 'vuex'



export default {
  name: 'App',
  components: {
    NavBar,
    MemberBar
    
  },
  data () {
    return {
         
     
    }
  },
  computed: {
        ...mapState(['memberLists'])
    },
  mounted () {
        this.fetchMemberList()
    },
  methods: {
    ...mapActions(['fetchMemberList'])
 
        }  
    
}
</script>
