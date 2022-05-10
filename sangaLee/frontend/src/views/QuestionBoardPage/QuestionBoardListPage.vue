<template>
  <div class="mainbg">
    <!-- sidebar -->
    <v-navigation-drawer app fixed permanent :width="150">
      <side-bar/>
    </v-navigation-drawer>

    <h1>질문 게시판</h1>
    
    <!-- 게시물 작성 버튼 -->
    <router-link :to="{ name: 'QuestionBoardRegisterPage' }">
        <button>글쓰기　<i class="fas fa-pencil-alt"></i></button>
    </router-link>

    <!-- 게시물 목록 -->
    <question-board-list :QuestionBoards="QuestionBoards"/>
  </div>
</template>


<script>

import SideBar from '../../components/Layout/SideBar.vue'
import QuestionBoardList from '../../components/QuestionBoard/QuestionBoardList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'QuestionBoardListPage',
    components: {
        QuestionBoardList,
        SideBar
    },
    computed: {
        ...mapState(['QuestionBoards'])
    },
    mounted () {
        this.fetchQuestionBoardList()
    },
    methods: {
        ...mapActions(['fetchQuestionBoardList'])
    }
}

</script>

<style scoped>
.mainbg {
  height: 100vh;
  padding: 55px;
  color: #6768ab;
}
button {
color: #6768ab;
letter-spacing: 0.1em;
font-weight: bold;
margin-left: 980px;
}
</style>