<template>
  <div>
    <menu-bar/>
    <board-list :boards="boards"/>


  </div>
</template>

<script>
import MenuBar from '@/components/MenuBar.vue'
import BoardList from '@/components/board/BoardList.vue'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'HomeView',
  components: {
    MenuBar,
    BoardList
    },
    computed: {
        ...mapState(['boards']),
        
    },
    mounted () {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList']),
    },
}
</script>

<style>


</style>