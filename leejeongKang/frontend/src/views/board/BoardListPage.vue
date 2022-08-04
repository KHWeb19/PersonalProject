<template>
<div id="board">
  <main-form/>
  <board-list :boards="boards"></board-list>
  <main-bottom/>
</div>
</template>

<script>
import BoardList from '@/components/board/BoardList.vue'
import MainForm from '@/components/main/MainForm.vue'
import MainBottom from '@/components/main/MainBottom.vue'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'BoardListPage',
  components: {
    BoardList,
    MainForm,
    MainBottom
  },
  computed: {
    ...mapState(['boards'])
  },
  mounted () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList'])
  }
}
</script>
