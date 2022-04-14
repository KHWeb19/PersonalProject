<template>
    <div >
        <v-container justify-center>
<v-row>
        <v-card @click="tipRead(tipBoard.boardNo)"
            v-for="tipBoard in tipBoards" 
            
            
            :key="tipBoard.boardNo"
            style="margin:10px; width: 250px; height: 300px;">
            <router-link :to="{ name: 'TipReadPage',
                                        params: { boardNo: tipBoard.boardNo.toString() } }">
                <v-card-title>{{ tipBoard.title }}</v-card-title>
            </router-link>
            <v-card-text>{{ tipBoard.content }} </v-card-text>
        </v-card>
</v-row>
        </v-container>
    </div>
</template>

<script>
export default {
    name: 'TipBoardList',
    props: {
      tipBoards: {
            type: Array
        },
        boardNo: {
            type: String,
            required: true
        }
    },
}
</script>

<style scoped>
table {
    margin: 10px;
    width: 30%;
}
</style>