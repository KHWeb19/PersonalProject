<template>
    <div >
        <div class="title">
            <h3> {{ videoBoard.title }} </h3>
            <div class="subtitle">
                <p align="center" class="writer">{{ videoBoard.writer }}</p>
                <div class="day"> 
                {{ videoBoard.regDate.substring(0, 10) }}
                {{new Date(videoBoard.regDate).
                    toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).
                        toString().substr(13, 11)}}
                </div>
            </div>
        </div>

        <div>
            <iframe class="video"
                    :src="require(`@/assets/uploadVideo/${videoBoard.fileName}`)" 
                    allow="autoplay muted">
            </iframe>
            <table>
                <tr>
                    <td>
                    <div> {{ videoBoard.content }}</div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script>


export default {
    name: 'VideoBoardRead',
    props: {
        videoBoard: {
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

.video {
    width: auto; 
    height: auto;
    width: 600px;
    height: 400px;
    margin-left: 30%;
    margin-bottom: 20px;
    border-top: 1px solid black;
}
table {
    margin-left: 30%; 
    height: 200px;
    width: 600px;
    border: 1px solid transparent;
}
td {    
    border-bottom: 1px solid black;
    padding: 10px;
    color: black;
}
.writer{
    background-color:#EEEEEE;
    width:120px;
    font-size: 19px;
}
.day{
    border-bottom:1px solid #EEEEEE;
    width:600px;
    font-size: 17px;
    color: black;

}

  
</style>