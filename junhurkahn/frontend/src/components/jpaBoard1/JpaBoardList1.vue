<template>

    <div>
        <h3>계좌번호 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">번호</th> 
                <th align="center" width="240">은행명</th>
                <th align="center" width="200">계좌번호</th>
                <th align="center" width="200">소유자이름</th>
                <th align="center" width="240">등록날짜</th>
            </tr>
            <tr v-if="!jpaBoards1 || (Array.isArray(jpaBoards1) && jpaBoards1.length === 0)">
                <td colspan="5">
                    현재 등록된 게시물이 없습니다! 
                </td>
            </tr>
            <tr v-else v-for="board in jpaBoards1" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }} 
                </td>
                <td align="left">
                    <router-link :to="{ name: 'JpaBoardReadPage1',
                                        params: { boardNo: board.boardNo.toString() } }">
                        {{ board.title }}
                    </router-link>
                </td>
                <td align="right">
                    {{ board.writer }}
                </td>

                 <td align="right">
                    {{ board.writer1 }}
                </td>


                <td align="center">
                    {{ board.regDate }}  <button @click="onDelete"> <h4>삭제</h4></button> 
                </td>
            </tr>
        </table>
    </div>

</template>

<script>

import axios from 'axios'
import { mapActions,mapState} from 'vuex'


export default {
 
    name: 'JpaBoardList1',
    props: {
      jpaBoards1: {
            
            type: Array,
             required: true
        }
    },
       computed: {
        ...mapState(['jpaBoard1'])
       },

     

     methods: {
        ...mapActions(['fetchJpaBoard1']),
        onDelete () {
            const { boardNo } = this.jpaBoard1
            //alert('지우는 게시물 번호: ' + boardNo)
            axios.delete(`http://localhost:7777/62th/board1/${boardNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'JpaBoardListPage1' })
                    })
                    .catch(() => {
                        alert('삭제 실패! 문제 발생!')
                    })
        }
    }

    

   
        }
    



</script>