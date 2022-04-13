<template>
    <div>
      <v-container>
        <v-row>
            <v-col v-for="video in  paginatedData" :key="video.boardNo" class="d-flex child-flex" cols="4">
                <router-link :to="{ name: 'VideoBoardReadPage', params: { boardNo: video.boardNo.toString() } }">
              <v-card class="video-card">
                  <div>
                    <!-- 파일말고 링크 가지고 오고싶은데 어케하노-->
                    <iframe :src="require(`@/assets/uploadVideo/${video.fileName}`)" 
                            height="300" width="100%" 
                            allow="autoplay 'none'">
                    </iframe>
                  </div>

                  <v-card-title>{{video.title}}</v-card-title>
          <v-list-item>
            <v-list-item-subtitle>
              <strong>{{ video.writer }}</strong>
              {{ video.regDate.substring(0, 10) }}
              조회 {{ video.count}}
            </v-list-item-subtitle>
          </v-list-item>
              </v-card>
                </router-link>
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

      <!--등록 버튼-->
      <router-link class="register-btn"
                    :to="{ name: 'VideoBoardRegisterPage'}">
        <v-btn v-if="$store.state.isLogin == true" class="amber lighten-2">
            <strong>등록</strong>
        </v-btn>
      </router-link>
    </div>
</template>

<script>

export default {
    name: 'VideoBoardList',
    props: {
      videoBoards: {
            type: Array   
        }
    },
    data () {
        return {
            pageNum: 0,
            pageSize:6
        }
    },
    methods: {
        nextPage () {
            this.pageNum += 1;
        },
        prevPage () {
            this.pageNum -= 1;
        }
    },
    computed: {
        pageCount () {
            let listLeng = this.videoBoards.length,
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
      
            return this.videoBoards.slice(start, end);
        },
        
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
  text-decoration: underline; 
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
.video-card{
  background-color: #FFD54F;
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
  

</style>