<template>
<div>
 <p>proto type</p>
    <v-row align="center" justify="center">
        <!--name:homeview변경예정-->
    <router-link style="text-decoration: none;" :to="{name:'K1QuestionView'}">
    <v-btn class="blue lighten-5"> 질문 게시판 보러가기</v-btn>
    </router-link></v-row>
    <br>
    <v-divider></v-divider>
<br>

        <h3 text align="center">게시물 목록</h3>
          <table id="PreviewPage">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="320">제목</th>
              
            </tr>
            <tr v-if="!jpaBoards || (Array.isArray(jpaBoards) && jpaBoards.length === 0)">
                <td colspan="2">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in jpaBoards" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }}
                </td>
                <td align="left">
                    <router-link :to="{ name: 'JpaBoardReadPage',
                                        params: { boardNo: board.boardNo.toString() } }">
                        {{ board.title }}
                    </router-link>
                </td>
                <td align="right">
                    {{ board.writer }}
                </td>
                <td align="center">
                    {{ board.regDate }}
                </td>
            </tr>
        </table>   
    </div>


  <!--
  <v-card class="mt-5 pa-2" color="primary">
    <v-tooltip top>
      <template v-slot:activator="{on}">
        <p class="headline ma-3" v-on="on" @click="questionPage">question</p>
      </template>
      <span>이동하기</span>
    </v-tooltip>

    <v-divider></v-divider>
      <v-list v-for="question in questionList" :key="question.index" color="primary">
      <v-list-item-group>
        <v-list-item>
          <v-list-item-title @click="questionPage(question.boardNo, question.id)">
            {{ question.title }}
          </v-list-item-title>
        </v-list-item>
      </v-list-item-group>
    </v-list>-->
    
</template>

<script>
//import axios from 'axios'
export default {
    name:'QuestionBoardList',
  data () {
    return {
     questionList: []
    }
  }
}
</script>
<style scoped>
 #PreviewPage{
 margin:auto;
 width: 800px;
 border-top: 1px solid black;
 border-collapse: collapse;
 border-right: 1px solid black;
 border-left: 1px solid black;

}

td, th{
 
  border-bottom: 1px solid black;
  border-radius: 50px;
  padding:10px;
}
</style>