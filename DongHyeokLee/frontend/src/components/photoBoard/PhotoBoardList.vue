<template>
    <div>
      <v-container>
              <v-row>
                  <v-col v-for="photo in paginatedData" :key="photo.boardNo" class="d-flex child-flex" cols="4">
                      <router-link :to="{ name: 'PhotoBoardReadPage', params: { boardNo: photo.boardNo.toString() } }">
                    <v-card class="img-card" >
                        <div>
                          <v-img :src="require(`@/assets/uploadImg/${photo.fileName}`)" height="300" ></v-img>
                        </div>
                        <v-card-title>{{photo.title}}</v-card-title>
                <v-list-item>
                  <v-list-item-subtitle>
                    <strong>{{ photo.writer }}</strong>
                    {{ photo.regDate.substring(0, 10) }}
                    조회 {{photo.count}}  
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

      
          <!-- 검색 기능-->
       <!--   <input type="text" 
                class="search" 
                v-model="keyWord" 
                cols="70" 
                placeholder="검색어 입력" />
          <v-btn @click="searchBtn()" 
                  class="search-btn"
                  depressed small>
              <strong>검색</strong>
          </v-btn> -->
        <!-- 등록 버튼 -->
        <router-link class="register-btn"
                     :to="{ name: 'PhotoBoardRegisterPage'}">
          <v-btn v-if="$store.state.isLogin == true" class="amber lighten-2">
             <strong>등록</strong>
          </v-btn>
        </router-link>
      
      </div>
</template>

<script>

export default {
    name: 'PhotoBoardList',
    props: {
      photoBoards: {
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
            let listLeng = this.photoBoards.length,
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
      
            return this.photoBoards.slice(start, end);
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