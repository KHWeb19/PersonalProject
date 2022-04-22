<template>
 <v-container>
 <p>proto type</p>
    <v-row align="center" justify="center">
    <router-link style="text-decoration: none;" :to="{name:'K1QuestionView'}">
    <v-btn class="blue lighten-5">질문 게시판 보러가기 </v-btn>
    </router-link></v-row>

              
                
            <v-simple-table style="padding:20px 100px 100px 100px">
            <v-data-table
                :headers="headerTitle"
                :items="QuestionBoards"
                :page.sync="page"
                :items-per-page="5"
                hide-default-footer
                class="elevation-1" 
                @click:row="handleClick"
                @page-count="pageCount = $event"
            ></v-data-table>
            </v-simple-table>
                 
    <br>
            <div class="text-center pt-2">
            <v-pagination
                v-model="page"
                :length="pageCount"
                dark
            ></v-pagination>
          
 
            </div>
 </v-container>

</template>

<script>
export default {
    name:'HomeQuestionBoard',
    props:{
      QuestionBoards:[]
    },
     data () {
    return {
            page: 1,
            pageCount: 0,
            itemsPerPage: 10,
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
        handleClick(event, idx) {
            this.$router.push({
                            name: 'QuestionBoardReadPage',
                            params: { boardNo: String(idx.item.boardNo) }
                         })
        }
    },
      //mounted () {
     //   console.log(this.QuestionBoards.regDate)
       // console.log(this.QuestionBoards.boardNo)
 //}
}
</script>
<style scoped>
 
</style>