<template>
    <div >
        <div class="title">
            <h3> {{ photoBoard.title }} </h3>
            <div class="subtitle">
                <p>{{ photoBoard.writer }}</p>
                <span> {{ photoBoard.regDate.substring(0, 10) }}</span>
                <span> {{new Date(photoBoard.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).
                        toString().substr(12, 11)}}</span>
            </div>
        </div>

        <div>
            <v-img class="img" :src="require(`@/assets/uploadImg/${photoBoard.fileName}`)" ></v-img>
            <table>
                <tr>
                    <td>
                    <div> {{ photoBoard.content }}</div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script>



export default {
    name: 'PhotoBoardRead',
    props: {
        photoBoard: {
            type: Object,
            required: true
        }
    },
    components: {
       
      
    }
}
</script>

<style scoped>

.title{
    margin-left: 30%; 
    padding:15px;
    color:black;
    width:500px
}

.subtitle{
    margin-top: 10px;
}

.img {
    width: auto; 
    height: auto;
    max-width: 600px;
    max-height: 600px;
    margin-left: 30%;
    margin-bottom: 20px;
    border-top: 3px solid black;
}
table {
    margin-left: 30%; 
    height: 200px;
    width: 600px;
    border: 1px solid transparent;
}
td {    
    border-bottom: 3px solid black;
    padding: 10px;
    color: black;
}


  
</style>