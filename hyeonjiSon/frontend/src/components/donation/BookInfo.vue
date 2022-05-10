<template>
    <div>
        <v-dialog resisten max-width="560px">
            <template v-slot:activator="{ on }">
                <v-btn
                        :elevation="hover ? 16:2" v-on="on" 
                        style="margin: 35px; width: 300px; height: 150px; background-color: white" dark>
                <v-img src="@/assets/donation/donateBook.png" />
                </v-btn>
            </template>

                <v-card align="center">
                    <v-img src="@/assets/donation/book.jpg"/> 
                <br>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn style="background-color: darkKhaki; color: white; " text onclick="window.open('https://www.beautifulstore.org/')">
                            사이트로 바로가기
                        </v-btn>
                    </v-card-actions>
                </v-card>

      </v-dialog>
    </div>
</template>

<script>
export default {
    name: 'BookInfo', 
}
</script>