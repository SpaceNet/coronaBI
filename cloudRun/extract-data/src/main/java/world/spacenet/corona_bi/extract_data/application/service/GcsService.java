package world.spacenet.corona_bi.extract_data.application.service;

import static java.nio.charset.StandardCharsets.UTF_8;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import world.spacenet.corona_bi.extract_data.domain.configuration.GcsConfiguration;

@ApplicationScoped
public class GcsService {

  private final Logger log = LoggerFactory.getLogger(GcsService.class);

  @Inject GcsConfiguration gcsConfig;

  /**
   * @see [Github : googleapis/google-cloud-java](https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/src/main/java/com/google/cloud/examples/storage/snippets/CreateAndListBucketsAndBlobs.java)
   */
  public void uploadBlob(String uploadString, String bucketName, String blobName) {

    log.info(StringUtils.join("文字列をGCSにアップロードします：bucket=",bucketName,", blobのname=",blobName));

    // Credentials are inferred from the environment.
    Storage storage = StorageOptions.getDefaultInstance().getService();

    BlobId blobId = BlobId.of(bucketName, blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();

    // Upload a blob to the newly created bucket
    storage.create(blobInfo, uploadString.getBytes(UTF_8));

  }

}
