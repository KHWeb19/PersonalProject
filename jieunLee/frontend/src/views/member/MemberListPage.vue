<template>
  <div>
    <menu-bar/>


      <member-list :searchMembers="searchMembers"/>
  </div>
</template>

<script>
import MemberList from '@/components/member/MemberList.vue'
import MenuBar from '@/components/MenuBar.vue'
import { mapState, mapActions } from 'vuex'
export default {
  name: 'MemberListPage',
  components: {
    MenuBar,
    MemberList
    },
    computed: {
        ...mapState(['searchMembers']),
        
    },
    mounted () {
        this.fetchSearchMemberList()
    },
    methods: {
        ...mapActions(['fetchSearchMemberList']),
    },
}
</script>

<style>
</style>