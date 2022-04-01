<template>
    <div>
        <h3>게시물 목록</h3>
        <table>
            <tr>
                <td align="center" width="100">번호</td>
                <th align="center" width="640">제목</th>
                <th align="center" width="150">작성자</th>
                <th align="center" width="240">등록일자</th>
            </tr>
            <tr v-if="!freeBoards || (Array.isArray(freeBoards) && freeBoards.length === 0)">
                <td colspan="4" align="center">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="freeBoard in freeBoards" :key="freeBoard.boardNo">
                <td align="center">
                    {{ freeBoard.boardNo }}
                </td>
                <th align="center">
                    <router-link :to="{ name: 'FreeBoardReadPage',
                                        params: { boardNo: freeBoard.boardNo.toString() } }" style=" color:black;">
                        {{ freeBoard.title }}
                    </router-link>
                </th>
                <th align="center">
                    {{ freeBoard.writer }}
                </th>
                <th align="center">
                    {{ freeBoard.regDate.substring(0, 10) }}
                    <!--{{new Date(freeBoard.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(11, 8)}} -->
                    
                </th>
            </tr>
        </table>
    </div>
</template>

<script>

export default {
    name: 'FreeBoardList',
    props: {
      freeBoards: {
            type: Array
        },
    data () {
        return {
            

        }
    },
    methods: {
        
    
    },
    }
}

</script>


<style scoped>
  h3 {
      margin-left: 200px;
  }  

  table{
      margin-left: 180px;
      margin-top: 10px;
      margin-bottom: 10px;

  }

  a{
      text-decoration: none;

  }

  a:hover{
       text-decoration: underline; 
       color: black;
    
  }

  table {
    
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

</style>