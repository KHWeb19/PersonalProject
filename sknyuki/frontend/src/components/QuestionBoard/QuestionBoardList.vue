<template>
<div>
 <!--<p>proto type</p>

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
          <v-row align="center" justify="center">-->
              <div>
                
              <v-data-table
                :headers="headerTitle"
                :items="QuestionBoards"
                :key="QuestionBoards.boardNo"
                :items-per-page="10"
                class="elevation-1" >
                <template v-slot:[`item.title`]="{ item }">
                   <router-link :to="{ name: 'K1QuestionReadPage',
                                        params: { boardNo: item.boardNo.toString() } }">
                    {{ item.title }}
                   </router-link>
                </template>
                
            ></v-data-table>
                 <br>
      <v-row  justify="end">
    <router-link style="text-decoration: none;" :to="{name:'K1QuestionRegisterPage'}">
    <v-btn class="blue lighten-5">
      <v-icon small>mdi-pencil</v-icon> 글쓰기</v-btn>
    </router-link></v-row>
    <br>
            
            
        <!--name:homeview-> register로 변경예정-->

              </div>
</div>
              
  
    
  
  



</template>

<script>
export default {
    name:'QuestionBoardList',
    props:{
      QuestionBoards: []
    },
  data () {
    return {
            headerTitle: [
                            { text: '번호', value: 'boardNo', width: "70px" },
                            { text: '제목', value: 'title', width: "200px" },
                            { text: '작성자', value: 'writer', width: "50px" },
                            { text: '등록일자', value: 'regDate', width: "60px" }
                        ]
    }
  },
function: {
    },
    methods: {
        
    },
    
}
</script> 

<style scoped>
/* #BrandCheckBoard{
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
}*/
</style>