<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div id="modalPop" class="modal">
    <div class="modal-content" style="height: 320px">
        <h4>请选择导入类型</h4>

        <div>
            <form id="uploadForm" enctype="multipart/form-data">

                <div class="input-field col s12">
                    <select onchange="changeContent(this)">
                        <option value="" disabled selected>Choose your option</option>
                        <option value="select_1">指定网络图片URL</option>
                        <option value="select_2">本地上传图书图片</option>
                        <option value="select_3">指定图书名字</option>
                        <option value="select_4">指定图书ISBN号</option>
                    </select>
                </div>

                <div id='select_1' class='select_content input-field' hidden>
                    <input id='imageUrl' type='text' name='imageUrl'/>
                    <label for='imageUrl'>请输入网络图片url</label>
                </div>

                <div id='select_2' class="select_content file-field input-field" hidden>
                    <div class="btn">
                        <span>Upload File</span>
                        <input type="file" name="imageFile">
                    </div>
                    <div class="file-path-wrapper">
                        <input class="file-path validate" type="text">
                    </div>
                </div>

                <div id='select_3' class='select_content input-field' hidden>
                    <input id="bookName" type="text" name="bookName"/>
                    <label for="bookName">请输入图书名字</label>
                </div>

                <div id='select_4' class="select_content input-field" hidden>
                    <input id="bookISBN" type="number" name="bookISBN" data-length="13"/>
                    <label for="bookISBN">请输入图书ISBN号</label>
                </div>

            </form>
        </div>
    </div>

    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat" onclick="bookApi()">Submit</a>
    </div>
</div>

<div id="bookPop" class="modal" style="width: 70%;top: 15%">
    <div class="modal-content">
        <h4>请确定列表中可能的图书</h4>

        <div class="bookContainer">
        </div>
    </div>
</div>