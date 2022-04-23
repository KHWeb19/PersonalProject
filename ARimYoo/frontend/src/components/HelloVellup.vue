<template>
    <div>
        <v-img class="position-absolute" id="enterimg" @mouseover="mouseOver"
            :src="require('../assets/ghost_enter.png')"
            contain
            height="50" 
            width="50" 
        />
        <v-img 
            :src="require('../assets/dotStar.gif')"
            contain
            height="50%"
        />
        <button onclick="location.href='/main'" v-show="active"><img src="../assets/speech_bubble.gif" height="50" weight="50">
        </button>
    
    </div>
    
</template>

<script>

export default {
    name: 'HelloVellup',
    
    data() {
        return{ active: false }
        
    },
    methods: {
        mouseOver: function () {
           this.active = !this.active
        }
    }
}
</script>

<style scoped>
div {
    position: absolute;
    background: black;
    width:100%;
    height:100%;
  }
#enterimg{
    top: 50%;
    left: 50%;
}
button{
    position: absolute;
    top:45%;
    left:52%;
}
</style>

