<template>
<div>
 <p>proto type</p>

        <h3 text align="center">게시물 목록</h3>
          <table id="BrandCheckBoard">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="1000">제목</th>
                <th align="center" width="150">작성자</th>
                <th align="center" width="240">등록일자</th>
            </tr>
            <tr v-if="!jpaBoards || (Array.isArray(jpaBoards) && jpaBoards.length === 0)">
                <td colspan="4">
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
        <br>
          <v-row align="center" justify="center">
        <!--name:homeview-> register로 변경예정-->
    <router-link style="text-decoration: none;" :to="{name:'homeView'}">
    <v-btn class="blue lighten-5"> 글쓰기</v-btn>
    </router-link></v-row>
    </div>



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
 #BrandCheckBoard{
 margin:auto;
 width: 1600px;
 border-top: 1px solid black;
 border-collapse: collapse;
 border-right: 1px solid black;
 border-left: 1px solid black;

}

td, th{
 
  border-bottom: 1px solid black;
  padding:10px;
}
</style>