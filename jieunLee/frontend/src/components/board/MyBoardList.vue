<template>
    <v-container style="width: 1000px; margin-top: 85px; font-size: 14px">
        <v-flex>
            <hr style="border: 0; height: 1px; background: #d8d8d8; "/>
            <br/><br/>
            <v-row>
                <v-col style="height: 320px; text-align: center;" v-if="!myBoards || (Array.isArray(myBoards) && myBoards.length === 0)">
                현재 등록된 게시물이 없습니다!
                </v-col>
                <v-col v-else v-for="board in myBoards" :key="board.boardNo"  cols="4">
                    <router-link style="text-decoration: none; color: grey" :to="{
                                name: 'BoardReadPage',
                                params: {boardNo: board.boardNo.toString()}}">
                        <v-img :src="require(`@/assets/mImage/${board.boardImage}`)" aspect-ratio="1" />
                    </router-link>
                </v-col>
            </v-row>
            
        </v-flex>
    </v-container>
</template>

<script>
export default {
    name: 'MyBoardList',
    props: {
        myBoards: {
            type: Array
        }
    },
    methods: {
        onDelete() {
            const { boardNo } = this
            this.$emit('click', {boardNo})
        }
    }
}
</script>
