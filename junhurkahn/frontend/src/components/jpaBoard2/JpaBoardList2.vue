<template>
    <div>
        <h3>장보기 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="590">물건목록</th>
              
                <th align="center" width="240">등록날짜</th>
            </tr>
            <tr v-if="!jpaBoards2 || (Array.isArray(jpaBoards2) && jpaBoards2.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in jpaBoards2" :key="board.boardNo">
                <td align="center">
                    {{ board.boardNo }}
                </td>
                <td align="left">
                    <router-link :to="{ name: 'JpaBoardReadPage2',
                                        params: { boardNo: board.boardNo.toString() } }">
                        {{ board.title }}
                    </router-link>
                
                <td align="center">
                    {{ board.regDate }}  
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'JpaBoardList2',
    props: {
      jpaBoards2: {
            type: Array
        }
    }
}
</script>