<template>
    <div class="free-board" align="center">
        <h2 id="title">검색 결과</h2>
        <table>
            <tr class="list">
                <td align="center" width="100"><strong>번호</strong></td> 
                <td align="center" width="600"><strong>제목</strong></td>
                <td align="center" width="100"><strong>작성자</strong></td>
                <td align="center" width="150"><strong>등록일자</strong></td>
                <td align="center" width="80"><strong>조회수</strong></td>
            </tr>
            <tr v-if="!searchList || (Array.isArray(searchList) && searchList.length === 0)">
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
                       {{ freeBoard.title}} 
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

    <v-btn color="amber lighten-2">
        <router-link class="cancel"
                    :to="{ name: 'FreeBoardListPage' }">
        <strong> 돌아가기</strong>
        </router-link>
    </v-btn>

  
     
         
        
    </div>
</template>


<script>
export default {
        name: 'SearchList',
        props: {
            searchList: {
                type: Array,
                required: true
            }
        },
        data () {
            return {
                pageNum: 0,
                pageSize:10
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
                let listLeng = this.searchList.length,
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
        
                return this.searchList.slice(start, end);
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
.read{
    color:black;
}
#title {
    color: black;
    text-align: center;
    padding: 20px;   
    background-color:#FFD54F;
    margin-bottom:50px;
    font-family: 'Nanum Brush Script', cursive;
}
.cancel{
    color:black;
}
    
</style>