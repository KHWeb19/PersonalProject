<template>
    <div>
      <v-container>
              <v-row>
                  <v-col v-for="board in paginatedData" :key="board.boardNo" class="d-flex child-flex" cols="4">
                    <v-card class="img-card" >
                      <router-link :to="{ name:  readPage , params: { boardNo: board.boardNo.toString() } }">
                       <div class="boardNo"> <v-icon>mdi-account-box </v-icon> <span>{{ board.boardNo }} </span> </div>
                        <div>
                          <v-img v-if="accept == 'jpg'"  
                                :src="require(`@/assets/uploadImg/${board.fileName}`)" 
                                height="300" >
                          </v-img>
                          
                          <iframe v-if="accept == 'mp4'" 
                                  :src="require(`@/assets/uploadVideo/${board.fileName}`)" 
                                  height="300" width="100%" 
                                  allow="autoplay 'none'">
                          </iframe>
                        </div>
                        </router-link>
                        <v-card-title>{{board.title}}[{{board.commentCnt}}]</v-card-title>
                        
                <v-list-item>
                  <v-list-item-subtitle>
                    <strong>{{ board.writer }}</strong>
                    {{ board.regDate.substring(0, 10) }}
                    조회 {{board.count}}  
                    <!-- likeCheck ++ , likeCnt++ 해줘서 즉각적으로 바뀌는거 보여주게함-->
                    <v-icon v-if="board.likeCheck == 0 " 
                            @click="board.likeCheck++,board.likeCnt++, like(board.boardNo,board.likeCheck)">
                            mdi-cards-heart-outline
                    </v-icon>
                    
                    <v-icon v-else  
                            @click="board.likeCheck--,board.likeCnt--, unlike(board.boardNo,board.likeCheck)"
                            class="like">
                            mdi-cards-heart
                    </v-icon>
                    {{ board.likeCnt}}
                  </v-list-item-subtitle>
                </v-list-item>
                    </v-card>
                      
                  </v-col>
              </v-row>
      </v-container>

          <!-- 페이징 참고 https://pewww.tistory.com/5 -->
        <div class="btn-cover" align="center">
          <v-btn :disabled="pageNum === 0" @click="prevPage" class="page-prev" text>
            <v-icon>
                mdi-chevron-left
            </v-icon>
          </v-btn>
          <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} </span>
          <v-btn :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-next" text>
              <v-icon>
                  mdi-chevron-right
              </v-icon>
          </v-btn>
        </div>

         <div>
         <router-link class="register-btn"
                     :to="{ name: registerPage }">
          <v-btn v-if="$store.state.isLogin == true" class="amber lighten-2">
             <strong>등록</strong>
          </v-btn>
        </router-link>
         </div>
   
      
      </div>
</template>

<script>

import axios from 'axios';

export default {
    name: 'BoardList',
    props: {
        boards: {
            type: Array,
        },
        registerPage:{
            type: String
        },
        readPage:{
            type:String
        },
         accept:{
            type: String
        },
        boardName:{
          type: String,
      }
    },
    data () {
        return {
            pageNum: 0,
            pageSize:6,
            writer: this.$store.state.userInfo.nickname,
            path:''
        }
    },
    methods: {
        nextPage () {
            this.pageNum += 1;
        },
        prevPage () {
            this.pageNum -= 1;
        },
        like(boardNo,likeCheck) {
          const writer = this.writer
          axios.post(`http://localhost:7777/${this.boardName}` + '/like', 
                { writer, boardNo, likeCheck })
                    .then(() => {
                         
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
                  
        },
        unlike(boardNo,likeCheck){
          const writer = this.writer

           axios.post(`http://localhost:7777/${this.boardName}` + '/unlike', 
                { writer, boardNo, likeCheck })
                    .then(() => {
                      
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        },
    },
    computed: {
        pageCount () {
            let listLeng = this.boards.length,
                listSize = this.pageSize,
                page = Math.floor(listLeng / listSize);
                
                if(listLeng % listSize > 0 ) {
                    page += 1;
                }

                return page
        },
         paginatedData () {
             const start = this.pageNum * this.pageSize,
             end = start + this.pageSize
      
            return this.boards.slice(start, end);
        }
        
    }
}

</script>


<style scoped>
    
h3 {
  margin-left: 200px;
}  
a{
  text-decoration: none;
}
a:hover{
  text-decoration: none; 
  color: black;
}
.boardNo{
  color: black;
}
table {
  margin-left: 180px;
  margin-top: 10px;
  margin-bottom: 10px;

  border-top: 1px solid ;
  border-collapse: collapse;
}
th {
  border-bottom: 1px solid ;
  border-left: 1px solid;
  padding: 10px;
}
td {    
  border-bottom: 1px solid;
  padding: 10px;
}
strong{
    margin-right: 5px;
}
.page-prev{
  color:#FFD54F;
}
.page-next{
  color: #FFD54F;
}
.page-count{
  color: black;
  margin-bottom:15px;
}
.register-btn{
  color:black;
}
.register-icon{
    font-size:1.7em;
}
.img-card{
  background-color: #FFD54F;
}
.register-btn{
  margin-left: 80%;
  margin-bottom: 20px;
}
.like {
  color: rgba(255, 0, 0, 0.73);
}

  

</style>