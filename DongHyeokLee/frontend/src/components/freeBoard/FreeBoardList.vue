<template>
    <div>
        <table>
            <tr class="list">
                <th align="center" width="100">번호</th> 
                <th align="center" width="600">제목</th>
                <th align="center" width="100">작성자</th>
                <th align="center" width="150">등록일자</th>
                <th align="center" width="80">조회수</th>
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
                    <router-link :to="{ name: 'FreeBoardReadPage',
                                        params: { boardNo: freeBoard.boardNo.toString() } }" style=" color:black;">
                        {{ freeBoard.title }}
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
    <div class="btn-cover">
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
     
        
     
         
        
    </div>
</template>

<script>

export default {
    name: 'FreeBoardList',
    props: {
      freeBoards: {
            type: Array
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
        color: black;
    }

    table {
        margin-left: 180px;
        margin-top: 10px;
        text-align: center;
        border-collapse: collapse;
    }
    
    th {
        padding: 10px;
    }

    .list{
        background-color: #FAFAFA;
        border-bottom: 1px solid;
    }

    .page-next {
        color: black;    
    }

    .page-prev {
        color:black;
    }

    .btn-cover {
        margin-left:43%;
    }
</style>