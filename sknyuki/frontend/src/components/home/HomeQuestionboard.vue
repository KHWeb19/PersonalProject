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
                :key="QuestionBoards.boardNo"
                :items-per-page="5"
                class="elevation-1" >
                <template v-slot:[`item.title`]="{ item }">
                   <router-link :to="{ name: 'K1QuestionReadPage',
                                        params: { boardNo: item.boardNo.toString() } }">
                    {{ item.title }}
                   </router-link>
                </template>  
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
            headerTitle: [
                            { text: '제목', value: 'title', width: "200px" },
                            { text: '작성자', value: 'writer', width: "50px" },
                        ]
    }
  },
function: {
    },
    methods: {
        }
}
      //mounted () {
     //   console.log(this.QuestionBoards.regDate)
       // console.log(this.QuestionBoards.boardNo)
 //}
 
</script>
<style scoped>
 
</style>