<template>
    <div id="free-board" align="center">
        <table>
            <tr class="list">
                <td align="center" width="100"><strong>번호</strong></td> 
                <td align="center" width="600"><strong>제목</strong></td>
                <td align="center" width="100"><strong>작성자</strong></td>
                <td align="center" width="150"><strong>등록일자</strong></td>
                <td align="center" width="80"><strong>조회수</strong></td>
            </tr>
            <tr v-if="!freeBoards || (Array.isArray(freeBoards) && freeBoards.length === 0)">
                <td colspan="5">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
        
            <tr v-else v-for="freeBoard in paginatedData" :key="freeBoard.boardNo">
                <th>
                    {{ freeBoard.boardNo }}
                </th>
                <th>
                    <router-link class="read" :to="{ name: 'FreeBoardReadPage',
                                        params: { boardNo: freeBoard.boardNo.toString() } }">
                       {{ freeBoard.title}} [{{freeBoard.commentCnt}}]
                    </router-link>
                </th>
            
                <th>
                    {{ freeBoard.writer }}
                </th>
                <th>
                    {{ freeBoard.regDate.substring(0, 10) }}
                </th>
                <th>
                    {{ freeBoard.count }}
                </th>
            </tr>
        </table> 

    <!-- 페이징 참고 https://pewww.tistory.com/5 -->
    <div class="page-btn">
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

    <!-- 검색 기능 -->
    <div class="btn-cover">
    <input type="text" 
           class="search" 
           v-model="keyWord" 
           cols="70" 
           placeholder="Search" />
    <v-btn @click="searchBtn()" 
            class="search-btn"
            depressed small>
        <strong>검색</strong>
        </v-btn>
          <!-- 등록 버튼 -->
    <router-link class="register-btn" :to="{ name: 'FreeBoardRegisterPage'}">
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
    name: 'FreeBoardList',
    props: {
      freeBoards: {
            type: Array
        },
    },
    data () {
        return {
            pageNum: 0,
            pageSize:10,
            searchList:[],
            keyWord:''
        }
    },
    methods: {
        nextPage () {
            this.pageNum += 1;
        },
        prevPage () {
            this.pageNum -= 1;
        },
        searchBtn() {
            const keyWord = this.keyWord
            console.log(keyWord)
            axios.post('http://localhost:7777/freeBoard/search',  { keyWord })
                    .then((res) => {
                        console.log("검색 성공")
                        console.log(res.data)
                        this.$router.push({name: 'SearchResult',
                                    params: { searchList: res.data} })
                    })
        }
    },
    computed: {
        pageCount () {
            let listLeng = this.freeBoards.length,
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
      
            return this.freeBoards.slice(start, end);
        }
    }
    
}

</script>


<style scoped>

a{
    text-decoration: none;
    
}
a:hover{
    text-decoration: underline; 
    
}
table {
    margin-top: 10px;
    text-align: center;
    border-collapse: collapse;
}

th {
    padding: 10px;
    color: black;
    
}
td{
    background-color:#FFD54F;
    padding: 10px;
    color: black;
    
}

.list{
    /*background-color: #FAFAFA;*/
    border-bottom: 1px solid black;
    color: black;
}

.page-next {
    color: #FFD54F;    
}

.page-prev {
    color:#FFD54F;
}
.page-count{
    color:black;
}

.page-btn {
    margin-top: 15px;
    margin-bottom:15px;
}
.register-btn{
    margin-left: 250px;
}
.read{
    color:black;
}
.search{
    border-bottom: 3px solid grey;
    outline: none;
    margin-left: 360px;
    
}
.search-btn{
    margin-left:5px;
}
</style>