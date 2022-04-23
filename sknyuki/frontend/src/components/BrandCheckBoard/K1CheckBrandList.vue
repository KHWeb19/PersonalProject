<template>
<!--
 <p>proto type</p>

        <h3 text align="center">게시물 목록</h3>
          <table id="BrandCheckBoard">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="1000">제목</th>
                <th align="center" width="150">작성자</th>
                <th align="center" width="240">등록일자</th>
            </tr>
            <tr v-if="!BrandCheckBoards || (Array.isArray(BrandCheckBoards) && BrandCheckBoards.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in BrandCheckBoards" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }}
                </td>
                <td align="left">
                    <router-link :to="{ name: 'K1CheckBrandReadPage',
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
        <br>-->
         
              <div>
                 
           
             <v-data-table
                :headers="headerTitle"
                :items="BrandCheckBoards"
                :key="BrandCheckBoards.boardNo"
                :items-per-page="10"
                class="elevation-1" >
                <template v-slot:[`item.title`]="{ item }">
                   <router-link :to="{ name: 'K1CheckBrandReadPage',
                                        params: { boardNo: item.boardNo.toString() } }">
                    {{ item.title }}
                   </router-link>
                </template>
                
            ></v-data-table>
         
                 <br>
  <v-row  justify="end">
       <!--name:homeview-> register로 변경예정-->
    <router-link style="text-decoration: none;" :to="{name:'K1CheckBrandRegisterPage'}">   
    <v-btn class="blue lighten-5">
      <v-icon small>mdi-pencil</v-icon> 글쓰기</v-btn>
    </router-link></v-row>
    <br>
  
              </div>

              

</template>

<script>
export default {
    name:'K1CheckBrandList',
    props:{
      BrandCheckBoards: []
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
    methods: {
      
    },

}
</script> 

